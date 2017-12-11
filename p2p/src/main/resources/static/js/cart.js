var TTCart = {
	load : function(){
		
	},
	itemNumChange : function(){
		$(".increment").click(function(){//＋
			var _thisInput = $(this).siblings("input");
			_thisInput.val(eval(_thisInput.val()) + 1);
			var sku=_thisInput.attr("itemId");

			//异步修改购物车中该商品的数量
			$.get("/cart/update/"+sku+"/"+_thisInput.val(),function(d){
				//更新总价款
				 $(".totalSkuPrice").html(d);
			});

		});
		$(".decrement").click(function(){//-
			var _thisInput = $(this).siblings("input");
			if(eval(_thisInput.val()) == 1){
				return ;
			}
			_thisInput.val(eval(_thisInput.val()) - 1);
            var sku=_thisInput.attr("itemId");

            //异步修改购物车中该商品的数量
            $.get("/cart/update/"+sku+"/"+_thisInput.val(),function(d){
                //更新总价款
                $(".totalSkuPrice").html(d);
            });

		});
		$(".quantity-form .quantity-text").rnumber(1);//限制只能输入数字
		$(".quantity-form .quantity-text").change(function(){
			var _thisInput = $(this);
            var id=_thisInput.attr("itemId");

            //异步修改购物车中该商品的数量
            $.get("/cart/update/"+id+"/"+_thisInput.val(),function(d){
                $(".totalSkuPrice").html(d);
            });

		});
	},
	refreshTotalPrice : function(){ //重新计算总价
		var total = 0;
		$(".quantity-form .quantity-text").each(function(i,e){
			var _this = $(e);
			total += (eval(_this.attr("itemPrice")) * 10000 * eval(_this.val())) / 10000;
		});
		$(".totalSkuPrice").html(new Number(total/100).toFixed(2)).priceFormat({ //价格格式化插件
			 prefix: '￥',
			 thousandsSeparator: ',',
			 centsLimit: 2
		});
	}
};

$(function(){
	TTCart.load();
	TTCart.itemNumChange();
});