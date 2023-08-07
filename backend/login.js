var db = require('./db');
//var templates = require('./template2.js');
var urlm = require('url');
var qs = require('querystring');

module.exports = {
  home: function(request, response){
    console.log(request.query);
    response.send({"result": "GET 호출"});
  },
    login: function(request, response){
    console.log(request.query);
    response.send({"result": "GET 호출"});
  },
    login_process: function(request, response){
      const {loginid, pwd} = request.body;
        db.query(`SELECT loginid, pwd, user_id FROM user WHERE loginid = ? and pwd = ?`,
            [loginid, pwd], function(error, result){ 
                if(error){
                    throw error;
                  }
                if(result[0] === undefined){
                    console.log("login failed");
                    return response.status(statusCode.MATCH_ERR).send(messageCode.INVALID_USER);
                }else if (pwd !== result[0].pwd) {
                  console.log("비밀번호 오류");
                  return response.status(statusCode.MATCH_ERR).send(messageCode.INVALID_PW);
                }else{
                  console.log("login sucess");
                  response.writeHead(302, {Location: `/closet`});
                  response.send(result[0].user_id);
                }
      });
  },
  register: function(request,response){
    const {loginid, pwd, user_name, nickName, height, weight, gender} = request.body;
    db.query(`INSERT INTO user (loginid, pwd, user_name, nickName, profile_img, height, weight, gender) 
                VALUES(?, ?, ?,?,NULL,?,?,?)`,[loginid, pwd, user_name, nickName, height, weight, gender], function(error, result){
                    if(error){
                        throw error;
                    }
                    response.writeHead(302, {Location: `/login`});
                    response.send();
              });
    }
}


