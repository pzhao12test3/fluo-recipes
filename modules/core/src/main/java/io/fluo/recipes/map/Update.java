/*
 * Copyright 2014 Fluo authors (see AUTHORS)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.fluo.recipes.map;

import com.google.common.base.Optional;

public class Update<K, V> {

  private final K key;
  private final V oldValue;
  private final V newValue;

  Update(K key, V oldValue, V newValue) {
    this.key = key;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  public K getKey() {
    return key;
  }

  public Optional<V> getNewValue() {
    return Optional.fromNullable(newValue);
  }

  public Optional<V> getOldValue() {
    return Optional.fromNullable(oldValue);
  }
}