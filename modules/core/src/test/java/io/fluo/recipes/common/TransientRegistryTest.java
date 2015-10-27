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

package io.fluo.recipes.common;

import java.util.HashSet;

import io.fluo.api.config.FluoConfiguration;
import io.fluo.api.data.Bytes;
import org.junit.Assert;
import org.junit.Test;

public class TransientRegistryTest {
  @Test
  public void testBasic() {
    FluoConfiguration fluoConfig = new FluoConfiguration();

    HashSet<RowRange> expected = new HashSet<>();

    TransientRegistry tr = new TransientRegistry(fluoConfig.getAppConfiguration());

    RowRange rr1 = new RowRange(Bytes.of("pr1:g"), Bytes.of("pr1:q"));
    tr.addTransientRange("foo", rr1);
    expected.add(rr1);

    tr = new TransientRegistry(fluoConfig.getAppConfiguration());
    Assert.assertEquals(expected, new HashSet<>(tr.getTransientRanges()));

    RowRange rr2 = new RowRange(Bytes.of("pr2:j"), Bytes.of("pr2:m"));
    tr.addTransientRange("bar", rr2);
    expected.add(rr2);

    tr = new TransientRegistry(fluoConfig.getAppConfiguration());
    Assert.assertEquals(expected, new HashSet<>(tr.getTransientRanges()));
  }
}