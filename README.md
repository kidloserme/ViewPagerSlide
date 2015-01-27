# ViewPagerSlide
Fragment中嵌套ViewPager，并实现导航滑动动画效果

本例子参考http://www.tuicool.com/articles/E7n6vu 并根据自己的实际情况做了相应的改进。

原文中滑动效果是通过不断的设置LayoutParams来实现的，而本例子中使用的是setX(float x)。
如果采用setLayoutParams的方法，那么在Activity中使用ViewPager是没有问题的，但是如果是在Fragment中
使用ViewPager，便会出现问题：第一次进入包含ViewPager的Fragment，不管你通过setCurrentItem(0)设置
默认显示是哪个fragment，导航中的高亮背景都只是显示在第一个，但是fragment的内容是正确的，原因是
setLayoutparams不起作用，但是你滑动一次之后，就起作用了。这个问题还有一个前提，就是这个包含ViewPager的
Fragment不是默认的Fragment，而是通过replace或者add的方式切换的。如果这样描述还不清楚，请多尝试。

来一张效果图吧，没搞好gif图片，就看静态的吧



