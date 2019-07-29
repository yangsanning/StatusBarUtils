# StatusBarUtils

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

[StatusBarUtils]:https://github.com/yangsanning/StatusBarUtils/blob/master/statusbar/src/main/java/ysn/com/statusbar/StatusBarUtils.java
