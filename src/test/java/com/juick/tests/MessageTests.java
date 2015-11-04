import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.juick.Message;

public class MessageTests {
	@Test
	public void messageTagsParser() {
		Message msg = new Message();
		msg.parseTags("test test" + (char)0xA0 + "2 test3");
		assertEquals("First tag must be", "test", msg.Tags.get(0));
		assertEquals("Third tag must be", "test3", msg.Tags.get(2));
		assertEquals("Count of tags must be", 3, msg.Tags.size());
	}
}