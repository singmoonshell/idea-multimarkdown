/*
 * Copyright (c) 2015-2020 Vladimir Schneider <vladimir.schneider@gmail.com>, all rights reserved.
 *
 * This code is private property of the copyright holder and cannot be used without
 * having obtained a license or prior written permission of the copyright holder.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package com.vladsch.md.nav.flex.language;

import com.vladsch.flexmark.test.util.spec.ResourceLocation;
import com.vladsch.flexmark.test.util.spec.SpecExample;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.md.nav.testUtil.cases.MdEnhSpecTest;
import com.vladsch.md.nav.flex.testUtil.cases.FlexOptionsForStyleSettings;
import com.vladsch.md.nav.testUtil.MdLightPlatformCodeInsightFixtureSpecTestCase;
import com.vladsch.plugin.test.util.cases.CodeInsightFixtureSpecTestCase;
import com.vladsch.plugin.test.util.renderers.LightFixtureSpecRenderer;
import com.vladsch.plugin.test.util.renderers.StripTrailingSpacesFilterSpecRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(value = Parameterized.class)
public class FlexmarkStripTrailingSpacesFilterFactoryTest extends MdLightPlatformCodeInsightFixtureSpecTestCase implements FlexOptionsForStyleSettings {
    private static final String SPEC_RESOURCE = "flex_strip_trailing_spaces_spec_test.md";
    public static final ResourceLocation RESOURCE_LOCATION = ResourceLocation.of(FlexmarkStripTrailingSpacesFilterFactoryTest.class, SPEC_RESOURCE);

    public static final DataHolder OPTIONS = new MutableDataSet()
            .set(RENDERING_PROFILE, MdEnhSpecTest.ENHANCED_OPTIONS)
            .toImmutable();

    final private static Map<String, DataHolder> optionsMap = new HashMap<>();
    static {
        optionsMap.putAll(FlexOptionsForStyleSettings.getOptionsMap());
    }
    public FlexmarkStripTrailingSpacesFilterFactoryTest() {
        super(optionsMap, OPTIONS);
    }

    @Parameterized.Parameters(name = "{0}")
    public static List<Object[]> data() {
        return CodeInsightFixtureSpecTestCase.getTests(RESOURCE_LOCATION);
    }

    @Override
    public LightFixtureSpecRenderer<?> createExampleSpecRenderer(@NotNull SpecExample example, @Nullable DataHolder options) {
        return new StripTrailingSpacesFilterSpecRenderer(this, example, options);
    }
}
