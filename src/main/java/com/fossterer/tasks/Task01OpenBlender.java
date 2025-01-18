package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 1 - Opening a blender
 * takes 1 second
 */
public class Task01OpenBlender extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 1;
	}

}
