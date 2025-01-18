package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 12 - Serve
 * takes 1 second
 */
public class Task12Serve extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 1;
	}

}
