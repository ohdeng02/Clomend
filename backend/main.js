var db = require('./db');
var login = require('./login');
var clothe = require('./closet');
var recommend = require('./recommend');
var qs = require('querystring');

var express = require('express')
var http = require('http');
var app = express();
var bodyParser = require('body-parser');
const path = require('path');

app.use(express.json());
app.use(bodyParser.urlencoded({extended: false}));
//app.use(express.static('public'));

app.get('/', function(request, response){
    login.home(request,response);
});
app.get('/login', function(request, response){
    login.login(request,response);
});
app.post(`/login_process`, (req, res) => {
    login.login_process(request,response);
})
app.post(`/register`, (req, res) => {
    login.register(request,response);
})

app.get('/clothe',function(request, response){
    clothe.home(request, response);
})
app.get('/clothe/create', function(request, response){
    clothe.clotheCreate(request,response);
});
app.post('/clothe/create_process', function(request, response){
    clothe.clotheCreate_process(request,response);
});

app.get(`/clothe/update/:clotheId`, function(request, response){
  clothe.clotheUpdate(request, response);
});
app.put('/clothe/update_process/:clotheId', function(request, response){
    clothe.clotheUpdate_process(request,response);
});
app.delete('/clothe/delete_process/:clotheId', function(request, response){
    clothe.clotheDelete_process(request,response);
});
app.get('/clothe_detail/:clotheId', function(request, response){
    clothe.detail(request,response);
});
app.get('/recommend', function(request, response){
    recommend.recommend(request,response);
});
app.post('/recommend_result', function(request, response){
    recommend.recommend_result(request,response);
});
app.post('/recommend_save', function(request, response){
    recommend.recommend_save(request,response);
});

app.listen(3001, () => {
  console.log(`서버 실행, 포트 번호 3001`);
});



