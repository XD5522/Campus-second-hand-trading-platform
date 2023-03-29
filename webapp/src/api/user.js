import request from "@/utils/request";

export default {
    demo(){
        return request({
            url:"/test",
            method:"Get"
        })
    }
}