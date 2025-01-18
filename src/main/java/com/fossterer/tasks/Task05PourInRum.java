package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 5 - Pour in Rum takes
 * 1 second
 */
public class Task05PourInRum extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 1;
	}

}
