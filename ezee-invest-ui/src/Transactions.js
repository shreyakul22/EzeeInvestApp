import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Title from './Title';

// Generate Order Data
function createData(id, date, name, Amount, Credit, Saving) {
  return { id, date, name, Amount, Credit, Saving };
}

const rows = [
  createData(0, '16 Mar, 2019', 'Elvis Presley', 1000, 500, 12000),
  createData(1, '16 Mar, 2019', 'Paul McCartney', 1200, 200, 11866.99),
  createData(2, '16 Mar, 2019', 'Tom Scholz', 9000, 100, 111200.81),
  createData(3, '16 Mar, 2019', 'Michael Jackson', 222, 32, 143654.39),
  createData(4, '15 Mar, 2019', 'Bruce Springsteen', 5000, 200, 66212.79),
];

function preventDefault(event) {
  event.preventDefault();
}

const useStyles = makeStyles((theme) => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
}));

export default function Transactions() {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Title>Recent Transactions</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Date</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>Amount</TableCell>
            <TableCell>Credit</TableCell>
            <TableCell align="right">Saving</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.id}>
              <TableCell>{row.date}</TableCell>
              <TableCell>{row.name}</TableCell>
              <TableCell>{row.amount}</TableCell>
              <TableCell>{row.credit}</TableCell>
              <TableCell align="right">{row.saving}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="#" onClick={preventDefault}>
          See more transactions
        </Link>
      </div>
    </React.Fragment>
  );
}
