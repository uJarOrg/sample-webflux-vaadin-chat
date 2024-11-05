package com.iqkv.incubator.sample.reactivevaadinchat;

import java.time.Instant;

record Message(String username, String text, Instant time) {
}
