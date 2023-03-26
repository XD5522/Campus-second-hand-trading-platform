import request from "@/utils/request";
export default {

    register(){
        return request({
            url:'/user/register',
            method:'Post',
        })
    },

    getall(){
        return request({
            url:'user',
            method:'Get'
        })
    }
}