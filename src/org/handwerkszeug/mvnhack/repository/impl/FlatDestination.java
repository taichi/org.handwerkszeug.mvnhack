package org.handwerkszeug.mvnhack.repository.impl;

import java.io.File;
import java.net.URL;

import org.handwerkszeug.mvnhack.repository.Artifact;
import org.handwerkszeug.mvnhack.repository.Context;
import org.handwerkszeug.mvnhack.repository.Destination;
import org.handwerkszeug.mvnhack.repository.Repository;


public class FlatDestination implements Destination {

	protected static final Filter DEFAULT_FILTER = new Filter() {
		public boolean filter(String path) {
			return path.endsWith("jar") || path.endsWith("zip");
		}
	};

	protected File dest;

	protected Filter filter;

	public FlatDestination(File dir) {
		this(dir, DEFAULT_FILTER);
	}

	public FlatDestination(File dir, Filter filter) {
		this.dest = dir;
		this.filter = filter;
	}

	@Override
	public void copyFrom(Context context, Repository from, Artifact artifact) {
		DestinationUtil.copy(context, from, artifact, this);
	}

	@Override
	public File toDestination(Artifact artifact, URL from) {
		String path = from.getPath();
		path = path.substring(path.lastIndexOf('/') + 1);
		if (this.filter.filter(path)) {
			return new File(dest, path);
		}
		return null;
	}

	public interface Filter {
		boolean filter(String path);
	}
}
