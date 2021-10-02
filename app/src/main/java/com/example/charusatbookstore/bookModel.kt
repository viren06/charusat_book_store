package com.example.charusatbookstore

data class bookModel(var uid:String?=null,var college:String?=null,var department:String?=null,var semester:String?=null,var subject:String?=null,var price:String?=null,var discription:String?=null,
var img:String?=null,var bookid:String?=null) {
    constructor():this("","","","","","","","","")
}