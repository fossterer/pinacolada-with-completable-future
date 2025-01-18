/**
 * 
 */
package com.fossterer.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Individual tasks, since
 * need to be scheduled concurrently, will be designed as extensions of this
 * "abstract" {@link Runnable} implementation
 */
public abstract class ATask implements Runnable
{

	public static final Logger logger = LoggerFactory.getLogger(ATask.class);

	@Override
	public void run()
	{
		logger.info("Starting task [{} ms]", Long.toString(System.currentTimeMillis()));
		try
		{
			Thread.sleep(((long) getProcessingTimeInSeconds()) * 1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		logger.debug("Ending task [{} ms]", Long.toString(System.currentTimeMillis()));
	}

	protected abstract long getProcessingTimeInSeconds();

}
