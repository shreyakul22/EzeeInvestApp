const DataService = {};

DataService.fetchTransactionTableData = () => {
    let url = 'http://localhost:8080/api/fetch';
    return fetch(url, {
    method: 'GET'
    }).then(res => res.json());
};

export default DataService;