# StatusBarUtils
[![](https://jitpack.io/v/yangsanning/StatusBarUtils.svg)](https://jitpack.io/#yangsanning/StatusBarUtils)
[![API](https://img.shields.io/badge/API-19%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=19)

## 效果预览

| [StatusBarUtils]                      |
| ------------------------------- |
| [<img src="images/image1.gif" height="512"/>][StatusBarUtils]   | |


## 主要文件
| 名字             | 摘要           |
| ---------------- | -------------- |
|[StatusBarUtils]  | 状态栏管理工具 |

### 1.基本用法 

#### 1.1 普通状态栏
```android
StatusBarUtils.setColor(this, color, toolbar1,toolbar1...);
```

#### 1.2 渐变状态栏
```
GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
toolbar.setBackground(gradientDrawable);
StatusBarUtils.setGradientColor(MainActivity.this, toolbar);
```

#### 1.3 透明状态栏
```
StatusBarUtils.setTransparentForWindow(MainActivity.this);
```

#### 1.4 LightMode状态栏, 字体颜色及icon变亮(目前支持MIUI6以上, Flyme4以上, Android M以上)
```android
StatusBarUtils.setLightMode(MainActivity.this);
```

#### 1.5 DarkMode状态栏, 字体颜色及icon变黑(目前支持MIUI6以上, Flyme4以上, Android M以上)
```android
StatusBarUtils.setDarkMode(MainActivity.this);
```

### 2.添加方法

#### 2.1 添加仓库

在项目的 `build.gradle` 文件中配置仓库地址。

```android
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

#### 2.2 添加项目依赖

在需要添加依赖的 Module 下添加以下信息，使用方式和普通的远程仓库一样。

```android
implementation 'com.github.yangsanning:StatusBarUtils:1.0.0'
```

[StatusBarUtils]:https://github.com/yangsanning/StatusBarUtils/blob/master/statusbar/src/main/java/ysn/com/statusbar/StatusBarUtils.java
