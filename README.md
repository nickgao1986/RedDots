Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.nickgao1986:RedDots:2.0'
	}

###### 运行效果图：
![enter image description here](https://github.com/nickgao1986/RedDots/blob/master/11.png)
