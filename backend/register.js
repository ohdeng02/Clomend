var db = require('./db');
var qs = require('querystring');

router.post('/register', (req, res) =>{
    const body = req.body;
    const id = body.id;
    const pw = body.pw;
  
    db.query('select * from user where loginid=?',[loginid],(err,data)=>{
      if(data.length == 0){
          console.log('회원가입 성공');
          connection.query('insert into user(loginid, password) values(?,?)',[id,pw]);
          res.status(200).json(
            {
              "message" : true
            }
          );
      }else{
          console.log('회원가입 실패');
          res.status(200).json(
            {
              "message" : false
            }
          );
          
      }
      
    });
  });