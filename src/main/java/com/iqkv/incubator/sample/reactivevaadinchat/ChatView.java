/*
 * Copyright 2024 IQKV.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iqkv.incubator.sample.reactivevaadinchat;

import jakarta.annotation.security.PermitAll;
import java.util.ArrayList;

import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Command;

@Route("")
@PermitAll
class ChatView extends VerticalLayout {

  ChatView(ChatService service) {

    var messageList = new MessageList();
    var textInput = new MessageInput();

    setSizeFull();
    add(messageList, textInput);
    expand(messageList);
    textInput.setWidthFull();

    service.join().subscribe(message -> {
      var nl = new ArrayList<>(messageList.getItems());
      nl.add(new MessageListItem(message.text(), message.time(), message.username()));
      getUI().ifPresent(ui -> ui.access((Command) () -> messageList.setItems(nl)));
    });
    textInput.addSubmitListener(event -> service.add(event.getValue()));
  }
}
