package com.example.finalproject.mvp.view.list



interface ObjectItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}