package org.ujar.webfluxvaadinchat;

import java.time.Instant;

record Message(String username, String text, Instant time) {
}
