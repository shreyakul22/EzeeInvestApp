import React from 'react';
import Typography from '@material-ui/core/Typography';
import Title from './Title';

export default function Deposits(props) {
  var totalBalance = props.data.reduce((a, b) => a + (b['amount'] || 0), 0)
  return (
    <React.Fragment>
      <Title>Total Balance</Title>
      <Typography component="p" variant="h4">
        ${totalBalance}
      </Typography>
    </React.Fragment>
  );
}
