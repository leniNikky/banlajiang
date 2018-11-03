<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>添加产品</em></span>
    <span class="modular fr"><a href="Goods_list" class="pt-link-btn">产品列表</a></span>
  </div>
  <form action="AddGoods" method="post" enctype="multipart/form-data">
  <table class="list-style">
  <tr>
    <td style="text-align:right;width:15%;">商品编号：</td>
    <td><input type="text" class="textBox length-long" name="goodsNo"/></td>
   </tr>
   <tr>
    <td style="text-align:right;width:15%;">商品名称：</td>
    <td><input type="text" class="textBox length-long" name="goodsName"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">商品分类：</td>
    <td>
     <select class="textBox" name="gclass">
      <option>香辣</option>
      <option>麻辣</option>
      <option>甜辣</option>
      <option>酸辣</option>
      <option>其他</option>
      
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">定价：</td>
    <td>
     <input type="text" class="textBox length-short" name="goodsPrice"/>
     <span>元</span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">库存：</td>
    <td>
     <input type="text" class="textBox length-short" name="goodsCount"/>
     <span>件</span>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品展示图：</td>
    <td>
     <input type="file" id="suoluetu" name="goodsimg"/>
     
     
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品长图：</td>
    <td>
     <input type="file" id="suoluetu" name="pictext"/>
   
     
    </td>
   </tr>
  
   <tr>
    <td style="text-align:right;">商品主图1：</td>
    <td>
     <input type="file" id="chanpinzhutu1" name="gimg1"/>
    
     
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品主图2：</td>
    <td>
     <input type="file" id="chanpinzhutu2" name="gimg2"/>
    
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">商品主图3：</td>
    <td>
     <input type="file" id="chanpinzhutu3" name="gimg3"/>
     
    </td>
   </tr>
  
   <tr>
    <td style="text-align:right;">产品详情：</td>
    <td><textarea class="textarea" name="goodsIntr"></textarea></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" value="发布新商品" class="tdBtn"/></td>
   </tr>
  </table>
  </form>
 <!-- <script type="text/javascript">
 var a= document.getElementById("check");
 var picture1 = document.getElementById("picture1").value;
 a.onclick = function(){
	 if(picture1!=""){
		 alert("1");
	 }else{
		 alert("2");
	 }
 }
 </script> -->
 
 </div>
</body>
</html>