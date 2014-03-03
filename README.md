SocketServer
=========

SocketServer: https://github.com/lincolnge/SocketSever  
SocketClient: https://github.com/lincolnge/SocketClient  

PC 实时截桌面图片然后发送给 Android 手机，这个是 PC Server 端。


问题：
---------
传输的图片太大，传输速度太慢。

使用 thumbnailator 压缩图片
    
    import net.coobird.thumbnailator.Thumbnails;

下载地址：<https://code.google.com/p/thumbnailator/>


References:
---------
* sunny635533 (2013.05) <em>android客户端和java服务端之间用socket来传输图片</em> <http://blog.csdn.net/qingzi635533/article/details/8961180>
* <em>Thumbnailator API Documentation</em> <http://thumbnailator.googlecode.com/hg/javadoc/index.html>