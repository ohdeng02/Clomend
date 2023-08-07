var db = require('./db');
//var templates = require('./template2.js');
var urlm = require('url');
var qs = require('querystring');

function templateList(clothes){
    var list=[];
    var i =0;
    while(i<clothes.length){
        list.push({category_id:clothes[i].category_id, category_name:clothes[i].category_name});
        i+=1;
    }
    return list;
}

module.exports = {
    home: function(request, response){
        db.query(`SELECT * FROM clothes WHERE user_id=?`,[1], function(error, results){
            if(error){
                throw error;
            }
            var list=[];
            var i =0;
            while(i<results.length){
                list.push({clothe_id:results[i].clothe_id,clothe_name:results[i].clothe_name, description:results[i].description, 
                    color:results[i].color,image_id: results[i].image_id, category_id:results[i].category_id, season_id:results[i].season_id});
                i+=1;
            } //겹치니까 함수로 빼줄 수 있음.
            console.log('user info is : ', list);
            response.json(list);
        });
    },
    clotheCreate:function(request, response){
                console.log(request.query);
                response.send({"result": "옷등록하기"});        
    },
    clotheCreate_process:function(request, response){
        const {image_id, color, category_id, season_id, clothe_name, description} = request.body;
                db.query(`INSERT INTO clothes (user_id, image_id, color, category_id, season_id, clothe_name, description) 
                VALUES(1, 1, ?,?,?,?,?)`,[color, category_id, season_id, clothe_name, description], function(error, result){
                    if(error){
                        throw error;
                    }
                    response.writeHead(302, {Location: `/clothe`});
                    response.send();
            });
    },
    clotheUpdate:function(request, response){
        var clothe_id = request.params.clotheId;
        db.query(`SELECT * FROM clothes WHERE clothe_id=${clothe_id}`, function(error, result){
            if(error){
                throw error;
            }
            var list=[];
            list.push({image_id:result[0].image_id, color:result[0].color, category_id:result[0].category_id,
            season_id:result[0].season_id, clothe_name:result[0].clothe_name, description:result[0].description});
            response.json(list);
        });  
    },
    clotheUpdate_process:function(request,response){
        const {image_id, color, category_id, season_id, clothe_name, description} = request.body;
        clothe_id = request.params.clotheId;
        db.query('UPDATE clothes SET image_id=?, color=?, category_id=?, season_id=?, clothe_name=?, description=? WHERE clothe_id=?',
                [1, color, category_id, season_id, clothe_name, description, clothe_id], function(error, result){
                    response.writeHead(302, {Location: `/clothe_detail/${clothe_id}`});
                    response.send();
            });
    },
    clotheDelete_process:function(request, response){
        var clothe_id = request.params.clotheId;
        db.query('DELETE FROM clothes WHERE id = ?', [clothe_id], function(error,result){
            if(error){
                throw error;
            }
            response.writeHead(302, {Location: `/clothe`});
            response.send();
        });
    },
    detail:function(request,response){
            var clothe_id = request.params.clotheId;
            db.query(`SELECT * FROM clothes where id=${clothe_id}`, function(error, result){
                if(error){
                    throw error;
                }
                var list=[];
                list.push({image_id:result[0].image_id, color:result[0].color, category_id:result[0].category_id,
                season_id:result[0].season_id, clothe_name:result[0].clothe_name, description:result[0].description});
                response.json(list);
        });
    }
}