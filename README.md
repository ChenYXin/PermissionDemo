## Android6.0运行时权限封装(避免用户选择不再提示后无法获取权限的问题)
Android 6.0 为了保护用户隐私，将一些权限的申请放在了应用运行的时候去申请， 比如以往的开发中，开发人员只需要将需要的权限在清单文件中配置即可，安装后用户可以在设置中的应用信息中看到：XX应用以获取**权限。用户点击可以选择给应用相应的权限。此前的应用权限用户可以选择允许、提醒和拒绝。在安装的时候用户是已经知道应用需要的权限的。但是这样存在一个问题，就是用户在安装的时候，应用需要的权限十分的多（有些开发者为了省事，会请求一些不必要的权限或者请求全部的权限），这个时候用户在安装应用的时候也许并没有发现某些侵犯自己隐私的权限请求，安装之后才发现自己的隐私数据被窃取。其实Android6.0 动态权限一方面是为了广大用户考虑，另一方面其实是Google为了避免一些不必要的官司。 

目前针对Android6.0权限适配的逻辑代码，网上已经很多了。这里针对用户拒绝了权限请求并且选择了“□ 不在提示”时该如何处理。

▲以RECORD_AUDIO，CAMERA，READ_EXTERNAL_STORAGE为例。全部权限请求成功，直接看妹砸。下面看图 ヾ(◍°∇°◍)ﾉﾞ 没图我会乱说 

![](http://upload-images.jianshu.io/upload_images/3550596-096e5e896dcc77f9?imageMogr2/auto-orient/strip)  

▲当部分权限受限，且用户未选中“不再提示”，弹出对话框说明，并进行请求权限

![](http://upload-images.jianshu.io/upload_images/3550596-0f5d03938246194b?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

▲当部分权限受限，且用户选中“不再提示”，弹出对话框说明，引导用户到设置页手动授权

![](http://upload-images.jianshu.io/upload_images/3550596-688357eecda9ddec?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

## About me
❤ 我觉得大家一起学习和交流才会更有意思，如果您觉得我的文章还不错，或是对您有过帮助，欢迎Follow、Fork、Star .咱们大家一起学习，一起交流~~❤ 

Email ：donkor@yeah.net

csdn_blog: http://blog.csdn.net/donkor_

jianshu_blog: http://www.jianshu.com/u/10f35b1d7e12
