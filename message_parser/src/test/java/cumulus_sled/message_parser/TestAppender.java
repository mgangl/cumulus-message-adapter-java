package cumulus_message_adapter.message_parser;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.Filter;;

@Plugin(name = "TestAppender", category = "Core", elementType = "apender", printObject = true)
public class TestAppender extends AbstractAppender {
    private final ArrayList<String> _log = new ArrayList<String>();

    protected TestAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    public TestAppender()
    {
        super("Test", null, PatternLayout.createDefaultLayout(), false);
    }

    @Override
    public void append(final LogEvent event) {
        _log.add(event.getMessage().getFormattedMessage());
    }

    @PluginFactory
    public static TestAppender createAppender(@PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout, 
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            LOGGER.error("No name provided for TestAppender");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new TestAppender(name, filter, layout);
    }

    public String GetLogMessage(int index)
    {
        return _log.get(index);
    }
}
