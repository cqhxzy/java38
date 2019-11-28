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

## 内边距

  边框与元素之间即为内边距。

```css
    padding-top:上内边距，像素
    padding-right:右内边距
    padding-bottom:下内边距
    padding-left:左内边距

    /*缩写形式*/
    padding:10px; /*上、右、下、左四个方向的内边距为10px*/
    padding:10px 5px;/*上下10px，左右5px*/
    padding:1px 2px 3px; /*按顺时针方向，上1，右2，下3，左和右对应为2*/
    padding:1px 2px 3px 4px; /*按顺时针方向，依次上1，右2，下3，左4*/
```

## 计算盒子模型的实际宽度和高度

  默认情况下，`box-sizing:content-box;`盒子模型的边框和填充会影响元素在页面中的实际高度和宽度。 

  **实际宽度：左右边框宽度+左右填充距离+元素宽度=实际宽度**
  **实际高度：上下边框宽度+上下填充距离+元素高度=实际高度**

  设置`box-sizing:border-box;`,盒子模型的宽度和高度会由设计大小决定。元素的宽度和高度会自动的缩放。

## 圆角边框

  当我们为html的块元素设置了边框后，就能够看到在元素的四周有矩形的边框存在。网页设计中，为了使块元素更美观，因此在css3中引用了圆角边框的概念。
  在矩形的4角绘制最大半径的圆。

```css
    /* border-radius:像素; */
    border-radius:5px; /*在矩形的四个角绘制一个半径为5像素的圆*/
```
  因此利用圆角边框可以非常容易的实现一个圆形。实现圆形的前提为盒子必须是一个正方形。

```css
    div{
        width:100px;
        height:100px;
        border-radius:50px;/*在盒子的四个角绘制半径为50像素的圆*/
        border-radius:100%;/*和上面等价，绘制一个圆形*/
    }
```

## 盒子阴影

  同字体颜色阴影相似，盒子阴影是对盒子模型增加阴影。

```css
    box-shadow:x-offset y-offset 模糊范围 阴影大小 阴影颜色 [inset]内置阴影
```