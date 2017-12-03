package com.cmfs.extension.activity;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author cmfs
 */

public interface ActivityExtensionManager {

    int getExtensionSize();

    boolean hasExtension();

    boolean containExtension(ActivityExtension e);

    boolean addExtension(ActivityExtension e);

    boolean addExtensions(Collection<? extends ActivityExtension> c);

    boolean removeExtension(ActivityExtension e);

    Iterator<ActivityExtension> extensionIterator();

    void clearExtensions();
}
