package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 7 - Close blender
 * takes 1 second
 */
public class Task07CloseBlender extends ATask
{

	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 1;
	}

}
