var db = require('./db');
var urlm = require('url');
var qs = require('querystring');

function collabo(color){
    if (color=="black"){
        list=["black", "gray", "dark blue"]
    }
    else if(color=="bright blue"){
        list=["black","bright blue","dark blue"]
    }
    else if(color=="bright green"){
        list=["black","gray","white"]
    }
    else if(color=="bright orange"){
        list=["black", "bright orange","gray"]
    }
    else if(color=="bright pink"){
        list=["black", "dark blue","none"]
    }
    else if(color=="bright purple"){
        list=["black", "gray","bright pink"]
    }
    else if(color=="bright yellow"){
        list=["black", "gray","bright yellow"]
    }
    else if(color=="dark blue"){
        list=["dark blue", "black","gray"]
    }
    else if(color=="dark green"){
        list=["black", "gray","dark blue"]
    }
    else if(color=="dark orange"){
        list=["black", "dark orange","bright orange"]
    }
    else if(color=="dark pink"){
        list=["black", "dark pink","dark blue"]
    }
    else if(color=="dark purple"){
        list=["dark blue", "black","dark orange"]
    }
    else if(color=="dark skyblue"){
        list=["black", "dark skyblue","dark blue"]
    }
    else if(color=="dark yellow"){
        list=["black", "dark yellow","gray"]
    }
    else if(color=="gray"){
        list=["black", "gray","dark blue"]
    }
    else if(color=="white"){
        list=["black", "white","gray"]
    }
    else if(color=="khaki"){
        list=["black", "gray","none"]
    }
    return list;
}


module.exports = {
    recommend:function(request,response){
        db.query(`SELECT * FROM clothes WHERE user_id=? and category_id=?`,[1,"상의"], 
        function(error, results){
            if(error){
                throw error;
            }
            var list=[];
            var i =0;
            while(i<results.length){
                list.push({clothe_id:results[i].clothe_id,clothe_name:results[i].clothe_name, clothe_id:results[i].image_id});
                i+=1;
            } //겹치니까 함수로 빼줄 수 있음.
            console.log('user info is : ', list);
            response.json(list);
        });    
    },
    recommend_result:function(request,response){
        const {clothe_id} = request.body;
                db.query(`SELECT * FROM clothes WHERE clothe_id=?`,[clothe_id], function(error, result){
                    if(error){
                        throw error;
                    }
                    list=collabo(result[0].color);
                    for(i=0; i<3; i++){
                        if(list[i]=="none"){
                            list[i]=null;
                        }
                    }
                    db.query(`SELECT * FROM clothes WHERE color IN (?,?,?)`,[list[0],list[1],llist[2]], 
                    function(error2, result2){
                        if(error2){
                            throw error2;
                        }
                        var list2=[];
                        var i =0;
                        while(i<result2.length){
                            list2.push({clothe_id:result2[i].clothe_id,clothe_name:result2[i].clothe_name, clothe_id:result2[i].image_id});
                            i+=1;
                        }
                        response.json(list2);
                });
        });
    },
    recommend_save:function(request,response){
        const {image_id, clothe_id_1, clothe_id_2} = request.body;
                db.query(`INSERT INTO codi (user_id, image_id, category_id) VALUES(1, ?,'추천받은 코디')`,[image_id],
                function(error, result){
                    if(error){
                        throw error;
                    }
                    db.query(`SELECT * FROM clothes WHERE image_id=?`,[image_id],function(error2, result2){
                        db.query(`INSERT INTO codi_clothes (user_id, image_id, codi_id, clothe_id) 
                        VALUES(1, ?, ?, ?)`,[image_id, result2[0].codi_id, clothe_id_1],
                        function(error3, result3){
                            db.query(`INSERT INTO codi_clothes (user_id, image_id, codi_id, clothe_id) 
                            VALUES(1, ?, ?, ?)`,[image_id, result2[0].codi_id, clothe_id_2],
                            function(error4, result4){
                                response.send();
                        });
                });
            });
        });
    }
}