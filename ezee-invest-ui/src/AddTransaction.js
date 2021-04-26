import React from 'react';
import Title from './Title';
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";



export default function AddTransaction(props) {
  return (
    <React.Fragment>
      <Title>Add a new Transaction</Title>

        <Grid container>
            <Grid item xs={4} >
                <TextField size="medium" label="Description" fullWidth={true}/>
            </Grid>
            <Grid item xs>
                <TextField label="Amount" />
            </Grid>
            <Grid item xs>
                <TextField label="Type" />
            </Grid>
            <Grid item xs>
                <TextField label="Account" />
            </Grid>
        </Grid>
        <br/>
        <Grid container>
            <Grid item xs>
                <Button variant="contained" color="primary">
                    Add
                </Button>
            </Grid>
            <Grid item xs={11} />
        </Grid>

    </React.Fragment>
  );
}