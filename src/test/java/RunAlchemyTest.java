import cucumber.api.CucumberOptions;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "")
@IncludeTags({"smoke", "air", "fire", "ground", "water"})
@CucumberOptions(strict = true)
public class RunAlchemyTest {
}
