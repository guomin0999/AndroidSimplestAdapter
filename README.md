# AndroidSimplestAdapter
##简单使用Adapter.
* 适配器的超级简单写法.
* ListView RecyclerView通通只需实现一个方法.
* 妈妈再也不用担心我写多余的代码了!


***

        BeanAdapter<ItemBean> adapter = new BeanAdapter<ItemBean>(this, android.R.layout.simple_list_item_1) {
            public void getView(int i, ViewHolder holder, ItemBean bean) {
                holder.text(android.R.id.text1, bean.name);
            }
        };
        listView.setAdapter(adapter);

        RecyclerAdapter<ItemBean> adapter = new RecyclerAdapter<ItemBean>(this, android.R.layout.simple_list_item_1) {
            public void onBindViewHolder(ViewHolder holder, int i, final ItemBean bean) {
                holder.text(android.R.id.text1, bean.name);
            }
        };
        recyclerView.setAdapter(adapter);


***

引入:

    maven { url "https://jitpack.io" }
    
    compile 'com.github.guomin0999:AndroidSimplestAdapter:1.01'
    
    
