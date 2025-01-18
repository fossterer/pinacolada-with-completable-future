package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 10 - Get glasses takes
 * 2 seconds
 */
public class Task10GetGlasses extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 2;
	}

}
