export MYSQL_DATABASE=movieDB
export MYSQL_USER=root
export MYSQL_PASSWORD=root
if [[ -z "${MYSQL_CI_URL}" ]];then
export MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDB
echo $MYSQL_USER
fi