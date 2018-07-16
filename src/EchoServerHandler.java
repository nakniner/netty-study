import io.netty.channel.*;
import io.netty.buffer.*;
import java.nio.charset.*;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //do nothing.
        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());

        System.out.println("수신한 문자열 [" + readMessage + "]");

        ctx.write(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
