package com.fossterer.tasks;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Task 3 - Put Mix in blender
 * takes 2 seconds
 */
public class Task03PutMixInBlender extends ATask
{
	@Override
	protected long getProcessingTimeInSeconds()
	{
		return 2;
	}

}
