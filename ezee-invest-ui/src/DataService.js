const DataService = {};

DataService.fetchTransactionTableData = () => {
    let url = 'http://localhost:8080/api/fetch';
    return fetch(url, {
    method: 'GET'
    }).then(res => res.json());
};

DataService.insertTransaction = (msg) => {
    const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(msg)
        };
    return fetch('http://localhost:8080/api/transaction/add', requestOptions);
};

export default DataService;