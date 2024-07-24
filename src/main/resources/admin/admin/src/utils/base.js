const base = {
    get() {
        return {
            url : "http://localhost:8080/xinlijiankangxitong/",
            name: "xinlijiankangxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xinlijiankangxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生心理健康管理系统"
        } 
    }
}
export default base
