package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 6 - Add 2 cups ice
 * takes 2 seconds
 */
public class Task06AddTwoCupsIce extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 2;
	}

}
