/*
 * Copyright 2008-2015 the original author or authors.
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
package integration;

import griffon.core.GriffonApplication;
import griffon.util.CollectionUtils;
import org.codehaus.griffon.runtime.core.addon.AbstractGriffonAddon;

import javax.annotation.Nonnull;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Named("integration")
public class IntegrationAddon extends AbstractGriffonAddon implements Invokable {
    private boolean invoked;

    @Override
    public void init(@Nonnull GriffonApplication application) {
        invoked = true;
    }

    @Override
    public boolean isInvoked() {
        return invoked;
    }

    @Nonnull
    @Override
    public Map<String, Map<String, Object>> getMvcGroups() {
        return CollectionUtils.<String, Map<String, Object>>map()
            .e("simple", CollectionUtils.<String, Object>map()
                .e("model", "integration.SimpleModel")
                .e("view", "integration.SimpleView")
                .e("controller", "integration.SimpleController"))
            .e("sample", CollectionUtils.<String, Object>map()
                .e("model", "integration.SimpleModel")
                .e("view", "integration.SimpleView")
                .e("controller", "integration.SimpleController"));
    }

    @Nonnull
    @Override
    public List<String> getStartupGroups() {
        return Arrays.asList("sample");
    }
}
