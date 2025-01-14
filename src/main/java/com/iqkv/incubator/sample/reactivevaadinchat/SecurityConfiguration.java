/*
 * Copyright 2024 IQKV Team.
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

import java.util.Set;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
class SecurityConfiguration extends VaadinWebSecurity {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    setLoginView(http, LoginView.class);
  }

  @Bean
  UserDetailsManager userDetailsManager() {
    var users = Set.of("tony", "steve", "bruce", "natasha")
        .stream()
        .map(name -> User.withDefaultPasswordEncoder().username(name).password("pwd").roles("USER").build())
        .toList();
    return new InMemoryUserDetailsManager(users);
  }

}
