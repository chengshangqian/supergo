let obj = {};

// {key:value}
// {商品的id：商品的数量}

// 保存商品
obj.saveGoods = function(goodsList) {
  window.localStorage.setItem("goodsList", JSON.stringify(goodsList));
};

//获取所有商品
obj.getGoodsList = function() {
  return JSON.parse(window.localStorage.getItem("goodsList") || "{}");
};

//增加商品
obj.addGoods = function(goods) {
  let goodsList = this.getGoodsList();
  if (goodsList[goods.id]) {
    //  有该商品则追加商品数量,没有则添加
    goodsList[goods.id] += goods.num;
  } else {
    goodsList[goods.id] = goods.num;
  }
  this.saveGoods(goodsList);
};

// 删除商品
obj.removeGoods = function(id) {
  let goodsList = this.getGoodsList();
  delete goodsList[id];
  return this.saveGoods(goodsList);
};

//获取购物车的总数量
obj.getTotalCount = function() {
  let goodsList = this.goodsList();
  let values = Object.values(goodsList);
  let sum = 0;
  values.foreach(val => (sum += val));
  return sum;
};

export default obj;
