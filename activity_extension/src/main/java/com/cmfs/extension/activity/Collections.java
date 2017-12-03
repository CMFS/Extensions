package com.cmfs.extension.activity;

import android.support.annotation.NonNull;

import java.util.Collection;

/**
 * @author cmfs
 */

final class Collections {

    static <T> void foreach(@NonNull Collection<T> c, @NonNull Consumer<T> consumer) {
        if (c.isEmpty()) {
            return;
        }
        for (T t : c) {
            consumer.apply(t);
        }
    }

    static <T> boolean foreach(@NonNull Collection<T> c, @NonNull Predicate<T> predicate) {
        if (c.isEmpty()) {
            return false;
        }
        boolean isFailed = false;
        for (T t : c) {
            if (predicate.apply(t)) {
                isFailed = true;
                break;
            }
        }
        return isFailed;
    }

}
