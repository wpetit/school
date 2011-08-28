/**
 * 
 */
package fr.min.school.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * School logger.
 * 
 * @author Wilfried Petit
 * 
 */
public class SchoolLogger {

	public void logMethodEntry(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getSourceLocation()
				.getWithinType());
		if (logger.isInfoEnabled()) {
			Object[] args = joinPoint.getArgs();

			String infoLog = "Class : "
					+ joinPoint.getSourceLocation().getWithinType()
					+ ", Method : " + joinPoint.getSignature().toLongString();

			if (logger.isDebugEnabled()) {
				StringBuffer infoDebug = new StringBuffer(infoLog);
				if (args.length != 0) {
					infoDebug.append(", called with : ");
					for (Object o : args) {
						infoDebug.append("'" + o + "' ");
					}
				}
				logger.debug(infoDebug.toString());
			} else {
				logger.info(infoLog);
			}
		}

	}

	public void logMethodExit(StaticPart staticPart, Object result) {
		Logger logger = LoggerFactory.getLogger(staticPart.getSourceLocation()
				.getWithinType());
		if (logger.isInfoEnabled()) {
			StringBuffer stringBuffer = new StringBuffer("Class : "
					+ staticPart.getSourceLocation().getWithinType()
					+ ", Method : " + staticPart.getSignature().toLongString());
			if (logger.isDebugEnabled()) {
				stringBuffer.append(" returning: [" + result + "]");
				logger.debug(stringBuffer.toString());
			} else {
				logger.info(stringBuffer.toString());
			}
		}
	}

	public void logMethodThrow(JoinPoint joinPoint, Object thrown) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getSourceLocation()
				.getWithinType());
		if (logger.isErrorEnabled()) {
			StringBuffer stringBuffer = new StringBuffer("Method : "
					+ joinPoint.getSignature().toLongString());
			logger.error(stringBuffer.toString(), thrown);
		}
	}

}
