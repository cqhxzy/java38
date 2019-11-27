# 盒子模型

  在html中，块元素默认已矩形的形式存在。盒子模型就是对块元素的一种包装。
  盒子模型包括元素的内边距、边框、外边距等。

## 边框

  在盒子的外围有4个方向的边框。

```css
    border-width:4个边的边框宽度;
    /*
        solid:实线
        dashed:虚线
        dotted:点线
        double:双实线
    */
    border-style:4个边框的风格; solid|dashed|dotted|double
    border-color:4个边框颜色;

    border-top-width
    border-top-style
    border-top-color

    border-right-width
    border-right-style
    border-right-color
    ...

    /*缩写形式*/
    border:宽度 风格 颜色;
```

## 外边距

  外边距用于使元素距离其他元素的间距。
  外边距同样具有上、右、下、左4个方向。

```css
    margin-top:上外边距，像素
    margin-right:右外边距
    margin-bottom:下外边距
    margin-left:左外边距

    /*缩写形式*/
    margin:10px;   /*4个方向均为10*/
    margin:10px 5px; /*上下为10px，左右为5px*/
    margin:1px 2px 3px; /*按顺时针方向，上1，右2，下3，左和右对应为2*/
    margin:1px 2px 3px 4px; /*按顺时针方向，依次上1，右2，下3，左4*/

    /*在父级容器中居中显示*/
    margin:0 auto;
```